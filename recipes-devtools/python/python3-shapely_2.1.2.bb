SUMMARY = "Geometric objects, predicates, and operations"
HOMEPAGE = "https://github.com/shapely/shapely"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=771eb47113291428a083f6bf398fa3cb"

SRC_URI[sha256sum] = "2ed4ecb28320a433db18a5bf029986aa8afcfd740745e78847e330d5d94922a9"

S = "${WORKDIR}/shapely-${PV}"

inherit pypi python_setuptools_build_meta

DEPENDS += "python3 python3-cython-native geos python3-numpy"
RDEPENDS:${PN} += "python3-core python3-numpy"

export GEOS_INCLUDE_PATH = "${STAGING_INCDIR}"
export GEOS_LIBRARY_PATH = "${STAGING_LIBDIR}"

CFLAGS += "-Wno-incompatible-pointer-types"

# temporary hack to work-around this error
WARN_QA:append = " buildpaths"
ERROR_QA:remove = " buildpaths"
