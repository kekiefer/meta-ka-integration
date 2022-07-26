LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0c2eed7ba400a6fea8fec2a582b177e8"

SRC_URI = "git://github.com/Maratyszcza/FXdiv;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "63058eff77e11aa15bf531df5dd34395ec3017c8"

S = "${WORKDIR}/git"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "-DFXDIV_BUILD_TESTS=OFF -DFXDIV_BUILD_BENCHMARKS=OFF"

