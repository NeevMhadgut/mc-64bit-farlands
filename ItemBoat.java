import java.util.List;

public class ItemBoat extends Item {
   public ItemBoat(int par1) {
      super(par1);
      this.bR = 1;
   }

   @Override
   public ItemStack a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      float f = 1.0F;
      float f1 = par3EntityPlayer.x + (par3EntityPlayer.v - par3EntityPlayer.x) * f;
      float f2 = par3EntityPlayer.w + (par3EntityPlayer.u - par3EntityPlayer.w) * f;
      double d = par3EntityPlayer.l + (par3EntityPlayer.o - par3EntityPlayer.l) * f;
      double d1 = par3EntityPlayer.m + (par3EntityPlayer.p - par3EntityPlayer.m) * f + 1.62 - par3EntityPlayer.H;
      double d2 = par3EntityPlayer.n + (par3EntityPlayer.q - par3EntityPlayer.n) * f;
      bo vec3d = bo.b(d, d1, d2);
      float f3 = MathHelper.b(-f2 * 0.01745329F - (float) Math.PI);
      float f4 = MathHelper.a(-f2 * 0.01745329F - (float) Math.PI);
      float f5 = -MathHelper.b(-f1 * 0.01745329F);
      float f6 = MathHelper.a(-f1 * 0.01745329F);
      float f7 = f4 * f5;
      float f8 = f6;
      float f9 = f3 * f5;
      double d3 = 5.0;
      bo vec3d1 = vec3d.c(f7 * d3, f8 * d3, f9 * d3);
      MovingObjectPosition movingobjectposition = par2World.a(vec3d, vec3d1, true);
      if (movingobjectposition == null) {
         return par1ItemStack;
      }

      bo vec3d2 = par3EntityPlayer.k(f);
      boolean flag = false;
      float f10 = 1.0F;
      List list = par2World.b(par3EntityPlayer, par3EntityPlayer.y.a(vec3d2.a * d3, vec3d2.b * d3, vec3d2.c * d3).b(f10, f10, f10));

      for (int l = 0; l < list.size(); l++) {
         Entity entity = (Entity)list.get(l);
         if (entity.l_()) {
            float f11 = entity.j_();
            AxisAlignedBB axisalignedbb = entity.y.b(f11, f11, f11);
            if (axisalignedbb.a(vec3d)) {
               flag = true;
            }
         }
      }

      if (flag) {
         return par1ItemStack;
      }

      if (movingobjectposition.a == aat.a) {
         long i = movingobjectposition.b;
         int j = movingobjectposition.c;
         long k = movingobjectposition.d;
         if (!par2World.F) {
            if (par2World.getBlockId(i, j, k) == Block.aS.bO) {
               j--;
            }

            par2World.a(new EntityBoat(par2World, i + 0.5, j + 1.0, k + 0.5));
         }

         if (!par3EntityPlayer.aT.d) {
            par1ItemStack.a--;
         }
      }

      return par1ItemStack;
   }
}
