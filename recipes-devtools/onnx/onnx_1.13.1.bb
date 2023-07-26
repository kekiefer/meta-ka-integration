SUMMARY = "Open Neural Network Exchange"
HOMEPAGE = "https://github.com/onnx/onnx"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI += " \
    git://github.com/onnx/onnx.git;protocol=https;branch=rel-${PV} \
"

SRCREV = "ad834eb73ee0cd9b6fa9ea892caeed5fa17d7dc0"

inherit cmake

S = "${WORKDIR}/git"

DEPENDS += " \
    protobuf \
    protobuf-native \
    python3-pybind11 \
"

EXTRA_OECMAKE = " \
    -DONNX_VERIFY_PROTO3=ON \
    -DONNX_USE_PROTOBUF_SHARED_LIBS=ON \
    -DProtobuf_LIBRARY="${STAGING_LIBDIR}/libprotobuf.so" \
    -DONNX_DISABLE_STATIC_REGISTRATION=ON \
"
