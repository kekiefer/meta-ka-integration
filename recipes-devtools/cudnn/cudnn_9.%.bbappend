PACKAGES += " ${PN}-adv ${PN}-cnn ${PN}-ops"

RRECOMMENDS:${PN}:append = "\
    ${PN}-cnn \
"

FILES:${PN} = " \
    ${libdir}/libcudnn_engines*.so.* \
    ${libdir}/libcudnn_graph.so.* \
    ${libdir}/libcudnn_heuristic.so.* \
    ${libdir}/libcudnn.so.* \
"

FILES:${PN}-adv = " \
    ${libdir}/*_adv.so.* \
"

FILES:${PN}-cnn = " \
    ${libdir}/*_cnn.so.* \
"

FILES:${PN}-ops = " \
    ${libdir}/*_ops.so.* \
"

INSANE_SKIP:${PN}-adv = "ldflags"
INSANE_SKIP:${PN}-cnn = "ldflags"
INSANE_SKIP:${PN}-ops = "ldflags"
