SUMMARY = "Open Neural Network Exchange"
HOMEPAGE = "https://github.com/onnx/onnx"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI += "git://github.com/onnx/onnx.git;protocol=https;branch=rel-${PV} \
           file://0001-Revert-Delete-stl_backports.h-5370.patch \
           "

SRCREV = "b86cc54efce19530fb953e4b21f57e6b3888534c"

inherit cmake python3native

S = "${WORKDIR}/git"

DEPENDS += " \
    protobuf \
    protobuf-native \
    python3-pybind11 \
    python3-pybind11-native \
"

EXTRA_OECMAKE = " \
    -DONNX_VERIFY_PROTO3=ON \
    -DONNX_USE_PROTOBUF_SHARED_LIBS=ON \
    -DProtobuf_LIBRARY="${STAGING_LIBDIR}/libprotobuf.so" \
    -DONNX_DISABLE_STATIC_REGISTRATION=ON \
    -DBUILD_ONNX_PYTHON=ON \
"

FILES:${PN} += "${libdir}/*.so"
FILES_SOLIBSDEV = ""
