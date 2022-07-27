SUMMARY = "GenSON is a powerful, user-friendly JSON Schema generator."
HOMEPAGE = "https://github.com/wolverdude/genson/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6c30d55dbfb3a28d420d918534adf6b"

SRC_URI[sha256sum] = "8caf69aa10af7aee0e1a1351d1d06801f4696e005f06cedef438635384346a16"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core python3-json"
