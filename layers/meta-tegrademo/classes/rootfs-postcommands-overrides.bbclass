# No /var/volatile in our builds
ROOTFS_POSTPROCESS_COMMAND:remove = "empty_var_volatile;"

