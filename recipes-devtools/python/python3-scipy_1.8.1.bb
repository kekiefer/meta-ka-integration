SUMMARY = "SciPy: Scientific Library for Python"
HOMEPAGE = "https://www.scipy.org"
LICENSE = "BSD-2-Clause & BSD-3-Clause & MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=27ca2e35416b6316570bf126e08b7062"

SRC_URI += "file://0001-Allow-passing-flags-via-FARCH-for-mach.patch"
SRC_URI[md5sum] = "df5ce79288fc457238aeef18e8f70dfc"
SRC_URI[sha256sum] = "9e3fb1b0e896f14a85aa9a28d5f755daaeeb54c897b746df7a55ccb02b340f33"

inherit setuptools3 pypi

CLEANBROKEN = "1"

DEPENDS += "python3-setuptools-native python3-cython-native python3-pybind11-native python3-cython python3-pythran-native lapack libgfortran python3-numpy"

RDEPENDS:${PN} += "lapack python3-asyncio python3-cffi python3-cython python3-compression python3-core python3-ctypes python3-datetime python3-distutils python3-io python3-json python3-logging python3-math python3-misc python3-mmap python3-multiprocessing python3-numbers python3-numpy python3-pickle python3-profile python3-psutil python3-resource python3-shell python3-stringold python3-typing-extensions"

export LAPACK = "${STAGING_LIBDIR}"
export BLAS = "${STAGING_LIBDIR}"
export F77 = "${TARGET_PREFIX}gfortran"
export F90 = "${TARGET_PREFIX}gfortran"
export FARCH = "${TUNE_CCARGS}"

LDFLAGS:prepend := "${@" ".join(d.getVar('LDSHARED', True).split()[1:])} "
export LDSHARED := "${@d.getVar('LDSHARED', True).split()[0]}"

# Tell Numpy to look in target sysroot site-packages directory for libraries
LDFLAGS:append = " \
    -L${STAGING_DIR_TARGET}${PYTHON_SITEPACKAGES_DIR}/numpy/core/lib \
    -L${STAGING_DIR_TARGET}${PYTHON_SITEPACKAGES_DIR}/numpy/random/lib \
"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    IPython
#    StringIO
#    benchmarks.common
#    cPickle
#    matplotlib
#    matplotlib.collections
#    matplotlib.patches
#    matplotlib.pylab
#    matplotlib.pyplot
#    mpmath
#    mypy.api
#    scikits.umfpack
#    sksparse
#    sksparse.cholmod
#    sparse
#    sphinx.ext.autodoc
#    sympy
#    sympy.abc
#    sympy.polys.polyfuncs
#    threadpoolctl
