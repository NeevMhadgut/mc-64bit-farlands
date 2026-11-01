public class ItemSign extends Item {
   public ItemSign(int par1) {
      super(par1);
      this.bR = 1;
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      if (par7 == 0) {
         return false;
      }

      if (!par3World.getBlockMaterial(par4, par5, par6).a()) {
         return false;
      }

      if (par7 == 1) {
         par5++;
      }

      if (par7 == 2) {
         par6--;
      }

      if (par7 == 3) {
         par6++;
      }

      if (par7 == 4) {
         par4--;
      }

      if (par7 == 5) {
         par4++;
      }

      if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6)) {
         return false;
      }

      if (!Block.aD.canPlaceBlockAt(par3World, par4, par5, par6)) {
         return false;
      }

      if (par7 == 1) {
         int i = MathHelper.c((par2EntityPlayer.u + 180.0F) * 16.0F / 360.0F + 0.5) & 15;
         par3World.setBlockAndMetadataWithNotify(par4, par5, par6, Block.aD.bO, i);
      } else {
         par3World.setBlockAndMetadataWithNotify(par4, par5, par6, Block.aI.bO, par7);
      }

      par1ItemStack.a--;
      sc tileentitysign = (sc)par3World.getBlockTileEntity(par4, par5, par6);
      if (tileentitysign != null) {
         par2EntityPlayer.a(tileentitysign);
      }

      return true;
   }
}
