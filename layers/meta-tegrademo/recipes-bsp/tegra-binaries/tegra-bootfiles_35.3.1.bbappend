EXTRADEPS = "bootfiles"
EXTRADEPS:append:cryptparts = " custom-flash-layout"
DEPENDS += "${EXTRADEPS}"

PARTITION_FILE:cryptparts = "${STAGING_DATADIR}/custom-flash-layout/${PARTITION_LAYOUT_TEMPLATE}"
PARTITION_FILE:jetson-agx-orin-devkit-sb-cot = "${STAGING_DATADIR}/custom-flash-layout/${PARTITION_LAYOUT_TEMPLATE}"

do_install:append:cryptparts() {
    rm -f ${D}${datadir}/tegraflash/eks.img
    install -m 0644 ${STAGING_DATADIR}/bootfiles/eks_t234.img ${D}${datadir}/tegraflash/eks.img
}
