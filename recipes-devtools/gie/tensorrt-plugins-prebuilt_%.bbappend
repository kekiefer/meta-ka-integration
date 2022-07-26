# Get onnx from the recipe in this layer

# do_install:append() {
#     rm ${D}${libdir}/libnvonnxparser.so*
# }

# RDEPENDS:${PN} += "onnx-tensorrt"
# RDEPENDS:${PN}-dev += "onnx-tensorrt-dev"

PROVIDES = "${PN}"
RPROVIDES:${PN} = "${PN}"
RCONFLICTS:${PN} = "${PN}"
RPROVIDES:${PN}-dev = "${PN}-dev"
RCONFLICTS:${PN}-dev = "${PN}-dev"
