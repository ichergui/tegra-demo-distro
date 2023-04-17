DESCRIPTION = "Boot files for Orin AGX"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

INHIBIT_DEFAULT_DEPS = "1"
COMPATIBLE_MACHINE = "(tegra)"

SRC_URI = ""
SRC_URI:append:cryptparts = " file://eks_t234.img"

S = "${WORKDIR}"

do_configure() {
    :
}

do_compile() {
    :
}

do_install() {
    :
}

do_install:cryptparts() {
    install -d ${D}${datadir}/bootfiles
    install -m 0644 ${S}/eks_t234.img ${D}${datadir}/bootfiles/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit nopackages
