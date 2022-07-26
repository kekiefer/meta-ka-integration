LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1609499688b503850848d795dce4da2d"

SRC_URI = "git://github.com/Maratyszcza/pthreadpool;protocol=https;branch=master;name=pthreadpool \
           git://github.com/Maratyszcza/fxdiv;protocol=https;branch=master;name=fxdiv;destsuffix=fxdiv"

PV = "1.0+git${SRCPV}"

SRCREV_FORMAT = "pthreadpool_fxdiv"
SRCREV_pthreadpool = "1787867f6183f056420e532eec640cba25efafea"
SRCREV_fxdiv = "63058eff77e11aa15bf531df5dd34395ec3017c8"

S = "${WORKDIR}/git"

inherit cmake

#DEPENDS += "fxdiv"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "-DPTHREADPOOL_BUILD_TESTS=OFF -DPTHREADPOOL_BUILD_BENCHMARKS=OFF -DFXDIV_SOURCE_DIR=${WORKDIR}/fxdiv -DPTHREADPOOL_LIBRARY_TYPE=shared -DPTHREADPOOL_ALLOW_DEPRECATED_API=ON"

FILES:${PN} += "${libdir}/*.so"
#INSANE_SKIP:${PN} += "dev-so"

FILES_SOLIBSDEV = ""
