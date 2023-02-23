SUMMARY = "ONNX-TensorRT - TensorRT backend for running ONNX models"
HOMEPAGE = "https://github.com/onnx/onnx-tensorrt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=90c6355a9a91565fe861cb12af3c1af1"

SRC_URI = "gitsm://github.com/onnx/onnx-tensorrt;protocol=https;branch=${PV}-GA \
           file://0001-Use-external-onnx-build.patch \
           "

SRCREV = "3b008c466bcb7375aaf5cabf51b289fd34d40c44"

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
