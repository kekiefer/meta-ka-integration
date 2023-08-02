PACKAGES += " ${PN}-infer ${PN}-train"

RRECOMMENDS:${PN}:append = "\
    ${PN}-infer \
"

FILES:${PN} = " \
    ${libdir}/libcudnn.so.* \
"

FILES:${PN}-infer = " \
    ${libdir}/*_infer.so.* \
"

FILES:${PN}-train = " \
    ${libdir}/*_train.so.* \
"

INSANE_SKIP:${PN}-infer = "ldflags"
INSANE_SKIP:${PN}-train = "ldflags"
