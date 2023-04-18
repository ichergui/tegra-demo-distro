TEGRA_INITRD_ROOTFSMOUNT = ""
TEGRA_INITRD_BASEUTILS = "bash"
TEGRA_INITRD_INSTALL = "packagegroup-core-boot \
                        haveged \
                        lvm2-udevrules \
                        tegra-sysinstall-tools \
                        sysinstall-autoinstaller \
"

require initramfs-common.inc

SYSTEMD_DEFAULT_TARGET = "multi-user.target"

ROOTFS_POSTPROCESS_COMMAND =+ "make_varextra; remove_etc_initrd;"
ROOTFS_POSTPROCESS_COMMAND:prepend:testdistro-mender = "make_data; make_media_m2; "

make_varextra() {
    [ -d ${IMAGE_ROOTFS}/var/extra ] || install -d ${IMAGE_ROOTFS}/var/extra
    [ -d ${IMAGE_ROOTFS}/installer ] || install -d ${IMAGE_ROOTFS}/installer
}

make_data() {
    [ -d ${IMAGE_ROOTFS}/data ] || install -d ${IMAGE_ROOTFS}/data
}

make_media_m2() {
    [ -d ${IMAGE_ROOTFS}/media/m2 ] || install -d ${IMAGE_ROOTFS}/media/m2
}

# Don't want systemd trying to switch roots
remove_etc_initrd() {
   rm -f ${IMAGE_ROOTFS}/etc/initrd-release
}
