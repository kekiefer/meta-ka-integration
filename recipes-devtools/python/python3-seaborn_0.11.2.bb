SUMMARY = "seaborn: statistical data visualization"
HOMEPAGE = "https://seaborn.pydata.org"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2767e262b17b22f4c0d342af8ac1ce51"

SRC_URI[sha256sum] = "cf45e9286d40826864be0e3c066f98536982baf701a7caa386511792d61ff4f6"

S = "${WORKDIR}/seaborn-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-matplotlib python3-numpy python3-pandas python3-scipy"
