SUMMARY = "Marshal dataclasses to/from JSON. Use field properties with initial values. Construct a dataclass schema with JSON input."
HOMEPAGE = "https://github.com/rnag/dataclass-wizard"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=82e8e53f4dc2ba73d3c6804188bdb239"

SRC_URI[sha256sum] = "77a6584a758788ca0d32cf9d09ebbd3cb12e5eb5dcded4d846e358257f5fc3a0"

S = "${WORKDIR}/dataclass-wizard-${PV}"

inherit setuptools3 pypi

PACKAGECONFIG ?= ""

PACKAGECONFIG[timedelta] = ",,,python3-pytimeparse"
PACKAGECONFIG[yaml] = ",,,python3-pyyaml"

RDEPENDS:${PN} += "python3-core python3-datetime python3-json python3-logging python3-netclient python3-numbers python3-pprint python3-profile python3-typing-extensions"
