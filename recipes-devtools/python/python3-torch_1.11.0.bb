SUMMARY = "Tensors and Dynamic neural networks in Python with strong GPU acceleration"
HOMEPAGE = "https://pytorch.org/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=91a5dfdaccf53b27488cb3a639e986d5"

SRC_URI = "https://github.com/pytorch/pytorch/releases/download/v${PV}/pytorch-v${PV}.tar.gz \
           file://0001-Support-cross-build-environment-variables.patch \
           file://0002-caffe2-fix-cross-compiling.patch \
           file://0003-cuda.cmake-compatibility-with-cuda.bbclass.patch \
           file://0001-Fixes-for-yocto-build-workflow.patch \
           file://0003-Remove-rpath-setting.patch \
           "

SRC_URI[sha256sum] = "dc0c2b8d13c112a2b9ea8757a475b0ce2ca97cd19c50a8b70b8c286676616f1d"

inherit cmake setuptools3 cuda

S = "${WORKDIR}/pytorch-v${PV}"
B = "${S}/build"

PACKAGECONFIG ??= "fftw hiredis opencv"
PACKAGECONFIG:class-native ??= ""
PACKAGECONFIG:cuda ??= "fftw hiredis opencv tensorrt magma"

PACKAGECONFIG[opencv] = ",,opencv"
PACKAGECONFIG[fftw] = ",,fftw"
PACKAGECONFIG[hiredis] = ",,hiredis"
PACKAGECONFIG[tensorrt] = ",,tensorrt-core tensorrt-plugins,python3-tensorrt"
PACKAGECONFIG[magma] = ",,magma"

DEPENDS += " \
    coreutils-native \
    protobuf-native \
    python3-numpy-native \
    python3-pyyaml-native \
    python3-typing-extensions-native \
    python3-pybind11-native \
    libeigen \
    sleef \
"

DEPENDS:append:cuda = " \
    cudnn \
    cuda-cupti \
    cuda-nvml \
    cuda-nvprof \
    cuda-nvrtc \
    cuda-nvtx \
    gloo \
    nccl \
"

EXTRA_OECMAKE:append = " \
    -DTORCH_INSTALL_LIB_DIR=${PYTHON_SITEPACKAGES_DIR}/torch/lib \
    -DPYTHON_INCLUDE_DIR=${PYTHON_INCLUDE_DIR} \
    -DUSE_SYSTEM_PYBIND11=ON \
    -DBUILD_CUSTOM_PROTOBUF=OFF \
    -DUSE_BREAKPAD=OFF \
    -DUSE_SYSTEM_EIGEN_INSTALL=ON \
    -DUSE_SYSTEM_SLEEF=ON \
"

EXTRA_OECMAKE:append:cuda = " \
    -DTORCH_CUDA_ARCH_LIST=7.2 \
    -DCMAKE_CUDA_COMPILER_FORCED=1 \
    -DUSE_CUPTI_SO=ON \
    -DUSE_SYSTEM_NCCL=ON \
    -DUSE_SYSTEM_GLOO=ON \
"

RDEPENDS:${PN} += " \
    python3-numpy \
    python3-typing-extensions \
"

export NUMPY_INCLUDE_DIR = "${STAGING_DIR_TARGET}${PYTHON_SITEPACKAGES_DIR}/numpy/core/include"
export BUILD_DIR = "${B}"

# cuda_extract_compiler() gets CXX sysroot arguments into the nvcc command, and
# -isystem is needed for g++ (when run under nvcc) to locate standard includes (e.g. <math.h>)
CUDA_NVCC_EXTRA_FLAGS = "${@cuda_extract_compiler('CXX_FOR_CUDA', d)[1]} -Xcompiler -isystem=${includedir}/c++/8.5.0"

# setuptools3_do_compile misses this for some reason
LDFLAGS:append:class-target = " -L${B}/lib"
# LDFLAGS is overwritten by native.bbclass
BUILD_LDFLAGS:append:class-native = " -L${B}/lib"

do_configure() {
    export CUFLAGS="${CUFLAGS}"
    cmake_do_configure
}

do_compile() {
    setuptools3_do_compile
}

do_install() {
    setuptools3_do_install
    cmake_do_install

    # we don't want pybind11 headers from here
    rm -rf ${D}${includedir}/pybind11

    # locate torch_shm_manager in the proper place
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}/torch/bin
    mv ${D}${bindir}/torch_shm_manager ${D}${PYTHON_SITEPACKAGES_DIR}/torch/bin/
}

FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}/torch/lib/ ${PYTHON_SITEPACKAGES_DIR}/torch/bin/"
FILES_SOLIBSDEV = ""

FILES:${PN}-dev += "${datadir}/ATen/*"

BBCLASSEXTEND = "native nativesdk"
