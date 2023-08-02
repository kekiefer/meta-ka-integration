SUMMARY = "General purpose utility library"
HOMEPAGE = "https://gitlab.com/madphysicist/haggis"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4ae09d45eac4aa08d013b5f2e01c67f6"

SRC_URI[sha256sum] = "5a4ac151db8ae1774ea6cfc723190cf02e496b5de2f11d29793c051b597d61c3"

S = "${WORKDIR}/haggis-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core python3-numpy"

do_install:append() {
    rm -f ${D}${prefix}/README.md
    rm -f ${D}${prefix}/CHANGELOG
    rm -f ${D}${prefix}/LICENSE
}
