SUMMARY = "ONNX-TensorRT - TensorRT backend for running ONNX models"
HOMEPAGE = "https://github.com/onnx/onnx-tensorrt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e149467d209874a32715c20e9fdafac5"

SRC_URI = "gitsm://github.com/onnx/onnx-tensorrt;protocol=https;branch=${PV}-GA"

SRCREV = "f42daeee49f2517a954c5601f0f76bef9ed94b62"

S = "${WORKDIR}/git"

inherit cmake setuptools3 cuda

DEPENDS += " \
    onnx \
    googlebenchmark \
    cmake-native \
    protobuf \
    python3-numpy-native \
    python3-protobuf \
    python3-pytest-runner-native \
    python3-pybind11-native \
    python3-protobuf-native \
    tensorrt-core \
    tensorrt-plugins \
"

RDEPENDS:${PN} += "onnx python3-core python3-ctypes python3-numpy python3-six python3-tensorrt"
RDEPENDS:${PN} += "python3-numpy python3-protobuf python3-typing-extensions python3-twine"
RDEPENDS:${PN} += "python3-compression python3-core python3-crypt python3-dataclasses python3-datetime python3-io python3-json python3-math python3-netclient python3-numbers python3-numpy python3-pytest python3-shell python3-unittest"
RDEPENDS:${PN} += "python3-pycuda"

# export CMAKE_ARGS=" \
#     -DONNX_USE_PROTOBUF_SHARED_LIBS=ON \
#     -DONNX_CUSTOM_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
#     -DProtobuf_LIBRARY="${STAGING_LIBDIR}/libprotobuf.so" \
# "

export CMAKE_ARGS=" \
    -DTENSORRT_ROOT=${STAGING_LIBDIR} \
"

do_configure() {
        cmake_do_configure
}

do_compile() {
        cmake_do_compile
        setuptools3_do_compile
}

do_install() {
        cmake_do_install
        setuptools3_do_install
}
