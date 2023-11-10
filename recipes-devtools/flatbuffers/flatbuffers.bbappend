do_install:append:class-target() {
    sed -i '/FlatcTargets.cmake/d' ${D}${libdir}/cmake/flatbuffers/flatbuffers-config.cmake
}
