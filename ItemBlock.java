public class ItemBlock extends Item {
   private int a;

   public ItemBlock(int par1) {
      super(par1);
      this.a = par1 + 256;
      this.e(Block.m[par1 + 256].a_(2));
   }

   public int d() {
      return this.a;
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

      if (par1ItemStack.a == 0) {
         return false;
      }

      if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6)) {
         return false;
      }

      if (par5 == 255 && Block.m[this.a].cd.a()) {
         return false;
      }

      if (par3World.canBlockBePlacedAt(this.a, par4, par5, par6, false, par7)) {
         Block block = Block.m[this.a];
         if (par3World.setBlockAndMetadataWithNotify(par4, par5, par6, this.a, this.a(par1ItemStack.i()))) {
            if (par3World.getBlockId(par4, par5, par6) == this.a) {
               Block.m[this.a].onBlockPlaced(par3World, par4, par5, par6, par7);
               Block.m[this.a].onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer);
            }

            par3World.a(par4 + 0.5, par5 + 0.5, par6 + 0.5, block.cb.d(), (block.cb.b() + 1.0F) / 2.0F, block.cb.c() * 0.8F);
            par1ItemStack.a--;
         }

         return true;
      } else {
         return false;
      }
   }

   @Override
   public String a(ItemStack par1ItemStack) {
      return Block.m[this.a].s();
   }

   @Override
   public String e() {
      return Block.m[this.a].s();
   }
}
