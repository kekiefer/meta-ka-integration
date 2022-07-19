SUMMARY = "Kalman filtering and optimal estimation library"
HOMEPAGE = "https://github.com/rlabbe/filterpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=486fe7f6e03034ab853c9383028b4531"

SRC_URI = "https://files.pythonhosted.org/packages/f6/1d/ac8914360460fafa1990890259b7fa5ef7ba4cd59014e782e4ab3ab144d8/filterpy-${PV}.zip"
SRC_URI[md5sum] = "40b17012e98c358e6e6827e05ba02398"
SRC_URI[sha256sum] = "4f2a4d39e4ea601b9ab42b2db08b5918a9538c168cff1c6895ae26646f3d73b1"

S = "${WORKDIR}/filterpy-${PV}"

inherit setuptools3

RDEPENDS:${PN} += "python3-matplotlib python3-numpy python3-scipy"
RDEPENDS:${PN} += "python3-core python3-math python3-numpy"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    matplotlib.patches
#    matplotlib.pyplot
#    mpl_toolkits.mplot3d
#    scipy.linalg
#    scipy.ndimage.filters
#    scipy.ndimage.interpolation
#    scipy.sparse
#    scipy.sparse.linalg
#    scipy.special.orthogonal
#    scipy.stats
