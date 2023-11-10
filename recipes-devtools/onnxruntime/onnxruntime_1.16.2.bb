SUMMARY = "onnxruntime"
HOMEPAGE = "https://onnxruntime.ai"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0f7e3b1308cb5c00b372a6e78835732d"

SRC_URI = "gitsm://github.com/microsoft/onnxruntime;protocol=https;branch=rel-${PV} \
           file://0001-Support-build-against-external-dependencies.patch \
           file://0002-Fix-build-with-cpuinfo-disabled.patch \
           file://0003-Fix-compilation-with-newer-flatbuffers-17164.patch \
           "

SRCREV = "0c5b95fc86750526d09ee9e669a98506116c6bde"

COMPATIBLE_MACHINE = "(cuda)"

inherit cmake setuptools3 cuda

S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += " \
    abseil-cpp \
    boost \
    date \
    flatbuffers \
    flatbuffers-native \
    libeigen \
    nlohmann-json \
    nsync \
    microsoft-gsl \
    protobuf \
    protobuf-native \
    python3-numpy-native \
    python3-packaging-native \
    python3-pybind11 \
    re2 \
    safeint \
    onnx \
    tensorrt-plugins \
"

RDEPENDS:${PN} += " \
    cuda-cudart \
    cuda-nvrtc \
    python3-coloredlogs \
    python3-flatbuffers \
    python3-numpy \
    python3-protobuf \
    python3-sympy \
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
    -DCMAKE_CXX_STANDARD=17 \
"

#    -DONNX_CUSTOM_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc 

OECMAKE_CXX_FLAGS:append = " -Wno-array-bounds -Wno-deprecated-declarations -Wno-unused-variable"

OECMAKE_SOURCEPATH = "${S}/cmake"
SETUPTOOLS_BUILD_ARGS = "--wheel_name_suffix=gpu --cuda_version=${CUDA_VERSION}"

do_configure() {
    cmake_do_configure
}

do_compile:prepend() {
    touch ${S}/requirements.txt
    python3 ${S}/onnxruntime/core/flatbuffers/schema/compile_schema.py --flatc ${STAGING_BINDIR_NATIVE}/flatc
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
