public class ItemReed extends Item {
   private int a;

   public ItemReed(int par1, Block par2Block) {
      super(par1);
      this.a = par2Block.bO;
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      int i = par3World.getBlockId(par4, par5, par6);
      if (i == Block.aS.bO) {
         par7 = 1;
      } else if (i != Block.bu.bO && i != Block.X.bO && i != Block.Y.bO) {
         if (par7 == 0) {
            par5--;
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
      }

      if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6)) {
         return false;
      }

      if (par1ItemStack.a == 0) {
         return false;
      }

      if (par3World.canBlockBePlacedAt(this.a, par4, par5, par6, false, par7)) {
         Block block = Block.m[this.a];
         if (par3World.setBlockWithNotify(par4, par5, par6, this.a)) {
            if (par3World.getBlockId(par4, par5, par6) == this.a) {
               Block.m[this.a].onBlockPlaced(par3World, par4, par5, par6, par7);
               Block.m[this.a].onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer);
            }

            par3World.a((float)par4 + 0.5F, par5 + 0.5F, (float)par6 + 0.5F, block.cb.d(), (block.cb.b() + 1.0F) / 2.0F, block.cb.c() * 0.8F);
            par1ItemStack.a--;
         }
      }

      return true;
   }
}
