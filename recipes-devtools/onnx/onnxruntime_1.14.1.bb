SUMMARY = "onnxruntime"
HOMEPAGE = "https://onnxruntime.ai"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0f7e3b1308cb5c00b372a6e78835732d"

SRC_URI = "gitsm://github.com/microsoft/onnxruntime;protocol=https;branch=rel-${PV} \
           file://0004-Fix-status-print-for-gcc-12.patch \
           file://0001-Support-build-against-external-dependencies.patch \
           file://0002-Fix-build-with-cpuinfo-disabled.patch \
           "

SRCREV = "c57cf374b67f72575546d7b4c69a1af4972e2b54"

COMPATIBLE_MACHINE = "(cuda)"

inherit cmake setuptools3 cuda

S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += " \
    boost \
    date \
    flatbuffers \
    flatbuffers-native \
    libeigen \
    nlohmann-json \
    nsync \
    microsoft-gsl \
    onnx \
    protobuf \
    protobuf-native \
    python3-numpy-native \
    python3-packaging-native \
    python3-pybind11 \
    re2 \
    safeint \
    tensorrt-plugins \
"

RDEPENDS:${PN} += " \
    cuda-cudart \
    cuda-nvrtc \
    python3-coloredlogs \
    python3-flatbuffers \
    python3-numpy \
    python3-protobuf \
"

EXTRA_OECMAKE = " \
    -Donnxruntime_BUILD_UNIT_TESTS=OFF \
    -Donnxruntime_DISABLE_ABSEIL=ON \
    -Donnxruntime_ENABLE_PYTHON=ON \
    -Donnxruntime_USE_TENSORRT=ON \
    -Donnxruntime_USE_TENSORRT_BUILTIN_PARSER=TRUE \
    -Donnxruntime_CROSS_COMPILING=ON \
    -Donnxruntime_USE_CUDA=ON \
    -Donnxruntime_CUDA_VERSION=${CUDA_VERSION} \
    -Donnxruntime_CUDA_HOME=${CUDA_TOOLKIT_ROOT} \
    -Donnxruntime_CUDNN_HOME=${CUDA_TOOLKIT_ROOT} \
    -Donnxruntime_ENABLE_CPUINFO=OFF \
    -DFETCHCONTENT_TRY_FIND_PACKAGE_MODE=ALWAYS \
    -Donnxruntime_USE_PREINSTALLED_EIGEN=ON \
    -Deigen_SOURCE_PATH=${STAGING_INCDIR}/eigen3 \
    -DCMAKE_SKIP_RPATH=ON \
"


OECMAKE_CXX_FLAGS:append = " -Wno-array-bounds"

OECMAKE_SOURCEPATH = "${S}/cmake"
SETUPTOOLS_BUILD_ARGS = "--wheel_name_suffix=gpu --cuda_version=${CUDA_VERSION}"

do_configure() {
    cmake_do_configure
}

do_compile:prepend() {
    touch ${S}/requirements.txt
    python3 ${S}/onnxruntime/core/flatbuffers/schema/compile_schema.py -f ${STAGING_BINDIR_NATIVE}/flatc
}

do_compile() {
    cmake_do_compile
    setuptools3_do_compile
}

do_install() {
    cmake_do_install
    setuptools3_do_install
}

FILES:${PN} += "${libdir}/*.so"
FILES_SOLIBSDEV = ""
