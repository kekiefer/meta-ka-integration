SUMMARY = "ONNX-TensorRT - TensorRT backend for running ONNX models"
HOMEPAGE = "https://github.com/onnx/onnx-tensorrt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=90c6355a9a91565fe861cb12af3c1af1"

SRC_URI = "git://github.com/onnx/onnx-tensorrt;protocol=https;branch=main \
           file://0001-Link-to-external-onnx.patch \
           "

SRCREV = "369d6676423c2a6dbf4a5665c4b5010240d99d3c"

inherit cmake setuptools3 cuda

COMPATIBLE_MACHINE = "(cuda)"

S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += " \
    onnx \
    tensorrt-core \
    tensorrt-plugins \
"

RDEPENDS:${PN} += "onnx python3-numpy python3-pycuda"

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
