SUMMARY = "Read and write TIFF files"
HOMEPAGE = "https://www.cgohlke.com"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6a1ad8909eb906bce279e7fe15877606"

SRC_URI[sha256sum] = "27bf927b0432fa064bed2426f8bf1778250288a1fc3badb7f4e36ece2e9a6240"

S = "${WORKDIR}/tifffile-${PV}"

inherit setuptools3 pypi

#PACKAGECONFIG ?= "all"
PACKAGECONFIG[all] = ",,,python3-imagecodecs python3-lxml python3-matplotlib"

RDEPENDS:${PN} += "python3-numpy"
