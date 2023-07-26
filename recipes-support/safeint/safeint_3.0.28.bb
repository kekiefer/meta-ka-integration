LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=052fd523d0ea51ed2fb75a46627e23bf"

SRC_URI = "git://github.com/dcleblanc/SafeInt.git;protocol=https;branch=master"

SRCREV = "ff15c6ada150a5018c5ef2172401cb4529eac9c0"

S = "${WORKDIR}/git"

inherit cmake

do_install:append() {
    rm -rf ${D}${datadir}
}
