SUMMARY = "Classes Without Boilerplate"
HOMEPAGE = "https://www.attrs.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d4ab25949a73fe7d4fdee93bcbdbf8ff"

SRC_URI[sha256sum] = "626ba8234211db98e869df76230a137c4c40a12d72445c45d5f5b716f076e2fd"

S = "${WORKDIR}/attrs-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core"
