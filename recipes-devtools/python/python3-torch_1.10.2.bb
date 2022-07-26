SUMMARY = "Tensors and Dynamic neural networks in Python with strong GPU acceleration"
HOMEPAGE = "https://pytorch.org/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=91a5dfdaccf53b27488cb3a639e986d5"

SRC_URI = "https://github.com/pytorch/pytorch/releases/download/v${PV}/pytorch-v${PV}.tar.gz \
           file://0001-Support-cross-build-environment-variables.patch \
           file://0002-caffe2-fix-cross-compiling.patch \
           file://0003-cuda.cmake-compatibility-with-cuda.bbclass.patch \
           file://0004-Fix-discovery-of-libnvToolsExt.so.patch \
           file://0001-Fixes-for-yocto-build-workflow.patch \
           file://0002-Fix-for-newer-GCC-null-pointer-check.patch \
           file://0003-Remove-rpath-setting.patch \
           "

SRC_URI[sha256sum] = "ae0e462d5e4eab79c5b52d4318c03522ebe94adfefee10a5c80b92c04aaae60b"

S = "${WORKDIR}/pytorch-v${PV}"
B = "${S}/build"

COMPATIBLE_MACHINE = "(cuda)"

inherit cmake setuptools3 cuda

PACKAGECONFIG ??= "fftw hiredis opencv"

PACKAGECONFIG[opencv] = ",,,opencv"
PACKAGECONFIG[fftw] = ",,,fftw"
PACKAGECONFIG[hiredis] = ",,,hiredis"

DEPENDS += " \
    coreutils-native \
    gloo \
    lapack \
    libeigen \
    nccl \
    protobuf-native \
    python3-numpy \
    python3-numpy-native \
    python3-pyyaml-native \
    python3-typing-extensions-native \
    python3-pybind11-native \
    sleef \
"

DEPENDS:append:cuda = " \
    cudnn \
    cuda-cupti \
    cuda-nvml \
    cuda-nvprof \
    cuda-nvrtc \
    cuda-nvtx \
    tensorrt-core \
    tensorrt-plugins \
"

EXTRA_OECMAKE += " \
    -DTORCH_CUDA_ARCH_LIST=7.2 \
    -DUSE_SYSTEM_SLEEF=ON \
    -DBUILD_CUSTOM_PROTOBUF=OFF \
    -DUSE_SYSTEM_NCCL=ON \
    -DUSE_SYSTEM_GLOO=ON \
    -DUSE_SYSTEM_PYBIND11=ON \
    -DUSE_SYSTEM_EIGEN_INSTALL=ON \
    -DUSE_BREAKPAD=OFF \
    -DTORCH_INSTALL_LIB_DIR=${PYTHON_SITEPACKAGES_DIR}/torch/lib \
    -DPYTHON_INCLUDE_DIR=${PYTHON_INCLUDE_DIR} \
"

RDEPENDS:${PN} += " \
    python3-astunparse \
    python3-asyncio \
    python3-audio \
    python3-boto3 \
    python3-botocore \
    python3-compression \
    python3-core \
    python3-crypt \
    python3-ctypes \
    python3-dataclasses \
    python3-datetime \
    python3-debugger \
    python3-difflib \
    python3-distutils \
    python3-hypothesis \
    python3-io \
    python3-json \
    python3-logging \
    python3-math \
    python3-matplotlib \
    python3-misc \
    python3-multiprocessing \
    python3-netclient \
    python3-numbers \
    python3-numpy \
    python3-packaging \
    python3-pickle \
    python3-pillow \
    python3-pkg-resources \
    python3-pprint \
    python3-profile \
    python3-psutil \
    python3-setuptools \
    python3-shell \
    python3-six \
    python3-sqlite3 \
    python3-statistics \
    python3-stringold \
    python3-threading \
    python3-typing-extensions \
    python3-unittest \
    python3-urllib3 \
    python3-xml \
"

RDEPENDS:${PN}:append:cuda = " \
    python3-tensorrt \
"

export NUMPY_INCLUDE_DIR = "${STAGING_DIR_TARGET}${PYTHON_SITEPACKAGES_DIR}/numpy/core/include"
export BUILD_DIR = "${B}"

# setuptools3_do_compile misses this for some reason
LDFLAGS += "-L${B}/lib"

do_configure() {
    cmake_do_configure
}

do_compile() {
    cmake_do_compile
    setuptools3_do_compile
}

do_install() {
    setuptools3_do_install
    cmake_do_install

    # locate torch_shm_manager in the proper place
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}/torch/bin
    mv ${D}${bindir}/torch_shm_manager ${D}${PYTHON_SITEPACKAGES_DIR}/torch/bin/
}

FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}/torch/lib/ ${PYTHON_SITEPACKAGES_DIR}/torch/bin/"
FILES_SOLIBSDEV = ""

FILES:${PN}-dev += "${datadir}/ATen/*"
