SUMMARY = "Open Neural Network Exchange"
HOMEPAGE = "https://github.com/onnx/onnx"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "9d941ba76cab55db8913ecad9dc50cefeb368460f6338a91783a5d7643f3a044"

inherit pypi cmake setuptools3

DEPENDS += " \
    googlebenchmark \
    cmake-native \
    protobuf \
    python3-numpy-native \
    python3-protobuf \
    python3-pytest-runner-native \
    python3-pybind11-native \
    python3-protobuf-native \
"

#PACKAGECONFIG ?= "lint"
PACKAGECONFIG[lint] = ",,,python3-clang-format python3-flake8 python3-mypy python3-types-protobuf"

# WARNING: the following rdepends are from setuptools install_requires. These
# upstream names may not correspond exactly to bitbake package names.
RDEPENDS:${PN} += "python3-numpy python3-protobuf python3-typing-extensions python3-twine"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-compression python3-core python3-crypt python3-dataclasses python3-datetime python3-io python3-json python3-math python3-netclient python3-numbers python3-numpy python3-pytest python3-shell python3-unittest"

export CMAKE_ARGS=" \
    -DONNX_CUSTOM_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
    -DProtobuf_LIBRARY="${STAGING_LIBDIR}/libprotobuf.so" \
    -DONNXIFI_ENABLE_EXT=ON \
    -DONNX_ML=ON \
    -DONNX_USE_PROTOBUF_SHARED_LIBS=ON \
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

FILES:${PN} += "${libdir}/*.so"
FILES_SOLIBSDEV = ""
