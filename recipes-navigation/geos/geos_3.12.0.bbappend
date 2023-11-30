
# Fix nothing provides 'geoslib' for nanbield
# master commit fixes in https://git.openembedded.org/meta-openembedded/commit/meta-oe/recipes-navigation/geos/geos_3.12.0.bb?id=405ee461078cfed493bd6ca06f922860be5081d0
FILES:${PN}lib += "${libdir}/libgeos.so.*"
