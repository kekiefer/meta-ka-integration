SUMMARY = "Geometric objects, predicates, and operations"
HOMEPAGE = "https://github.com/shapely/shapely"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=771eb47113291428a083f6bf398fa3cb"

SRC_URI[sha256sum] = "1713cc04c171baffc5b259ba8531c58acc2a301707b7f021d88a15ed090649e7"

S = "${WORKDIR}/shapely-${PV}"

inherit pypi setuptools3

DEPENDS += "python3 python3-cython-native python3-numpy-native geos python3-numpy"
RDEPENDS:${PN} += "python3-core python3-numpy"

export GEOS_INCLUDE_PATH = "${STAGING_INCDIR}"
export GEOS_LIBRARY_PATH = "${STAGING_LIBDIR}"

CFLAGS += "-Wno-incompatible-pointer-types"
