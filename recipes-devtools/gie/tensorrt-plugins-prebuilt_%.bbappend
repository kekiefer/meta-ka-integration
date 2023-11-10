
do_install:append() {
    rm -f ${D}${libdir}/libonnx_proto.a
}
