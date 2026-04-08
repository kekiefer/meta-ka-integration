SUMMARY = "Marshal dataclasses to/from JSON. Use field properties with initial values. Construct a dataclass schema with JSON input."
HOMEPAGE = "https://github.com/rnag/dataclass-wizard"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=82e8e53f4dc2ba73d3c6804188bdb239"

SRC_URI[sha256sum] = "1679948ed7c62103f40b34df97d03b35e6b2ad50f58173fdbe30074e2e4730f2"

S = "${WORKDIR}/dataclass_wizard-${PV}"
PYPI_PACKAGE = "dataclass_wizard"

inherit pypi python_setuptools_build_meta

PACKAGECONFIG ?= ""

PACKAGECONFIG[timedelta] = ",,,python3-pytimeparse"
PACKAGECONFIG[yaml] = ",,,python3-pyyaml"

RDEPENDS:${PN} += "python3-core python3-datetime python3-json python3-logging python3-netclient python3-numbers python3-pprint python3-profile python3-typing-extensions"
