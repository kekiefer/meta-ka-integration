SUMMARY = "pathlib-style classes for cloud storage services."
HOMEPAGE = "https://github.com/drivendataorg/cloudpathlib"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cfcc961cd4c64dfbde45e7bf973423c6"

SRC_URI[sha256sum] = "cdfcd35d46d529587d744154a0bdf962aca953b725c8784cd2ec478354ea63a3"

S = "${WORKDIR}/cloudpathlib-${PV}"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "python3-core python3-boto3"
