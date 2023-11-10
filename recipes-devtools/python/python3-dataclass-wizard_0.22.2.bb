SUMMARY = "Marshal dataclasses to/from JSON. Use field properties with initial values. Construct a dataclass schema with JSON input."
HOMEPAGE = "https://github.com/rnag/dataclass-wizard"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=82e8e53f4dc2ba73d3c6804188bdb239"

SRC_URI[sha256sum] = "211f842e5e9a8ace50ba891ef428cd78c82579fb98024f80f3e630ca8d1946f6"

S = "${WORKDIR}/dataclass-wizard-${PV}"

inherit setuptools3 pypi

PACKAGECONFIG ?= ""

PACKAGECONFIG[timedelta] = ",,,python3-pytimeparse"
PACKAGECONFIG[yaml] = ",,,python3-pyyaml"

RDEPENDS:${PN} += "python3-core python3-datetime python3-json python3-logging python3-netclient python3-numbers python3-pprint python3-profile python3-typing-extensions"
