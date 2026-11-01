public class ItemMonsterPlacer extends Item {
   public ItemMonsterPlacer(int par1) {
      super(par1);
      this.a(true);
   }

   @Override
   public String d(ItemStack par1ItemStack) {
      String s = ("" + cy.a(this.e() + ".name")).trim();
      String s1 = EntityList.a(par1ItemStack.i());
      if (s1 != null) {
         s = s + " " + cy.a("entity." + s1 + ".name");
      }

      return s;
   }

   @Override
   public int b(int par1, int par2) {
      hr entityegginfo = (hr)EntityList.a.get(par1);
      if (entityegginfo != null) {
         return par2 == 0 ? entityegginfo.b : entityegginfo.c;
      } else {
         return 16777215;
      }
   }

   @Override
   public boolean c() {
      return true;
   }

   @Override
   public int a(int par1, int par2) {
      return par2 > 0 ? super.a(par1, par2) + 16 : super.a(par1, par2);
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      if (par3World.F) {
         return true;
      }

      int i = par3World.getBlockId(par4, par5, par6);
      par4 += qs.b[par7];
      par5 += qs.c[par7];
      par6 += qs.d[par7];
      double d = 0.0;
      if (par7 == 1 && i == Block.aZ.bO || i == Block.bB.bO) {
         d = 0.5;
      }

      if (a(par3World, par1ItemStack.i(), par4 + 0.5, par5 + d, par6 + 0.5) && !par2EntityPlayer.aT.d) {
         par1ItemStack.a--;
      }

      return true;
   }

   public static boolean a(World par0World, int par1, double par2, double par4, double par6) {
      if (!EntityList.a.containsKey(par1)) {
         return false;
      }

      Entity entity = EntityList.a(par1, par0World);
      if (entity != null) {
         entity.c(par2, par4, par6, par0World.r.nextFloat() * 360.0F, 0.0F);
         par0World.a(entity);
         if (entity instanceof EntityLiving) {
            ((EntityLiving)entity).aZ();
         }
      }

      return entity != null;
   }
}
