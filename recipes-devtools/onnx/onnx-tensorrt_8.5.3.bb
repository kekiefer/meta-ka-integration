SUMMARY = "ONNX-TensorRT - TensorRT backend for running ONNX models"
HOMEPAGE = "https://github.com/onnx/onnx-tensorrt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aa3e92f9f2b6da1568c23ceaec468692"

SRC_URI = "gitsm://github.com/onnx/onnx-tensorrt;protocol=https;branch=main \
           file://0001-Fix-build-against-newer-protobuf-and-external-onnx.patch \
           "

SRCREV = "84fd16d86698334086e6efa95f337b5c35ddb75e"

inherit cmake setuptools3 cuda

COMPATIBLE_MACHINE = "(cuda)"

S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += " \
    protobuf \
    protobuf-native \
    python3-pybind11 \
    tensorrt-plugins \
    onnx \
"

EXTRA_OECMAKE = " \
    -DONNX_VERIFY_PROTO3=ON \
    -DONNX_USE_PROTOBUF_SHARED_LIBS=ON \
    -DProtobuf_LIBRARY="${STAGING_LIBDIR}/libprotobuf.so" \
    -DCMAKE_CXX_STANDARD=17 \
"

OECMAKE_CXX_FLAGS:append = " -Wno-array-bounds"

RDEPENDS:${PN} += "python3-numpy python3-pycuda tensorrt-plugins"

do_configure() {
        sed -i "/^import onnx_tensorrt/d" ${S}/setup.py
        sed -i "s/onnx_tensorrt.__version__/\"${PV}\"/g" ${S}/setup.py
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
