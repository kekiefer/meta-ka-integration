SUMMARY = "Create a source of truth for ML model results and browse it on Papers with Code"
HOMEPAGE = "https://github.com/paperswithcode/model-index"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a46c3c02b3af5e4179305e2d1fc059aa"

SRC_URI = "git://github.com/paperswithcode/model-index;protocol=https;branch=main"
SRCREV = "09c7865ab2cbe00827d3af879a2faf7d286cb1b7"

S = "${WORKDIR}/git"

inherit setuptools3

RDEPENDS:${PN} += "python3-click python3-markdown python3-ordered-set python3-pyyaml"

do_configure() {
    sed -i "/^from modelindex/d" setup.py
    sed -i "s/__version__/\"${PV}\"/g" ${S}/setup.py
}
