# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   COPYRIGHT
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=fbe75ba92e457d7555eb16a14f00502c"

SRC_URI = "http://icl.utk.edu/projectsfiles/magma/downloads/magma-${PV}.tar.gz \
           file://0001-Fix-cuda-compilation.patch \
           file://0002-Fix-magma.pc-generation.patch \
           "
SRC_URI[md5sum] = "93afad24924189c98fba0959aac51277"
SRC_URI[sha1sum] = "813e732bce1126d552ecf09dd04a48125f97e31a"
SRC_URI[sha256sum] = "75b554dab00903e2d10b972c913e50e7f88cbc62f3ae432b5a086c7e4eda0a71"
SRC_URI[sha384sum] = "16e325589e70368042848dbb8860ea52a5d1074232921db848c3041f1b6fa56fa13594192f5b9d6683e5ae125e44881f"
SRC_URI[sha512sum] = "c6c2665e7eedd1a8425c1ac3c053c22b3f7326b796404cf2aa4f99322146a95cf7be0323a88c2d92a713b083db5bc30150142958426a9d5ddb4eaa2a8044d95a"

# NOTE: unable to map the following CMake package dependencies: hipBLAS LAPACK hipSPARSE HIP CUDA
inherit cmake cuda

COMPATIBLE_MACHINE = "(cuda)"

DEPENDS += "lapack cuda-nvprof"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "-DGPU_TARGET=sm_${TEGRA_CUDA_ARCHITECTURE} -DMAGMA_ENABLE_CUDA=ON"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""
