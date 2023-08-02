SUMMARY = "pathlib-style classes for cloud storage services."
HOMEPAGE = "https://github.com/drivendataorg/cloudpathlib"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cfcc961cd4c64dfbde45e7bf973423c6"

SRC_URI[sha256sum] = "60e50a396cbc7b507859b3502b40f966cc9a37a5be6647e3ae9772cc5a9599f2"

S = "${WORKDIR}/cloudpathlib-${PV}"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "python3-core python3-boto3"
