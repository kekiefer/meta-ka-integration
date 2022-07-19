SUMMARY = "Extract semantic information about static Python code"
HOMEPAGE = "https://github.com/serge-sans-paille/beniget/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=02550c296a72ab0b70961eb70a5a7242"

#SRC_URI = "https://files.pythonhosted.org/packages/14/e7/50cbac38f77eca8efd39516be6651fdb9f3c4c0fab8cf2cf05f612578737/beniget-${PV}.tar.gz"
SRC_URI[md5sum] = "a2bbe7f17f10f9c127d8ef00692ddc55"
#SRC_URI[sha1sum] = "0167f16d17fbd61b91e620bca07e4ec7054ce51d"
SRC_URI[sha256sum] = "75554b3b8ad0553ce2f607627dad3d95c60c441189875b98e097528f8e23ac0c"
#SRC_URI[sha384sum] = "adedcf33c1636da474a4d7e5a7a3c0fa4f4b51a4c3d397b0039e20b5074c6e400026652f73c5f209f2a947fdf8db3e36"
#SRC_URI[sha512sum] = "c002dec769b070cf02038ce232edb905b66df7095b8ff1030ecae1b3810ebae7c1b9b0c38dd1c651b27afe538f01cfff0e54145c09c8e3318963af6a7c1588eb"

S = "${WORKDIR}/beniget-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core python3-gast"

BBCLASSEXTEND = "native nativesdk"
