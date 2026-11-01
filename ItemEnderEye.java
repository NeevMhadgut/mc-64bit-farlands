public class ItemEnderEye extends Item {
   public ItemEnderEye(int par1) {
      super(par1);
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      int i = par3World.getBlockId(par4, par5, par6);
      int j = par3World.getBlockMetadata(par4, par5, par6);
      if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6) || i != Block.bI.bO || BlockEndPortalFrame.e(j)) {
         return false;
      }

      if (par3World.F) {
         return true;
      }

      par3World.setBlockMetadataWithNotify(par4, par5, par6, j + 4);
      par1ItemStack.a--;

      for (int k = 0; k < 16; k++) {
         double d = (double)par4 + (5.0F + ItemEnderEye.d.nextFloat() * 6.0F) / 16.0F;
         double d1 = par5 + 0.8125;
         double d2 = (double)par6 + (5.0F + ItemEnderEye.d.nextFloat() * 6.0F) / 16.0F;
         double d3 = 0.0;
         double d4 = 0.0;
         double d5 = 0.0;
         par3World.a("smoke", d, d1, d2, d3, d4, d5);
      }

      int l = j & 3;
      int i1 = 0;
      int j1 = 0;
      boolean flag = false;
      boolean flag1 = true;
      int k1 = aav.f[l];

      for (int l1 = -2; l1 <= 2; l1++) {
         long l2 = par4 + aav.a[k1] * l1;
         long l3 = par6 + aav.b[k1] * l1;
         int l4 = par3World.getBlockId(l2, par5, l3);
         if (l4 == Block.bI.bO) {
            int l5 = par3World.getBlockMetadata(l2, par5, l3);
            if (!BlockEndPortalFrame.e(l5)) {
               flag1 = false;
               break;
            }

            if (!flag) {
               i1 = l1;
               j1 = l1;
               flag = true;
            } else {
               j1 = l1;
            }
         }
      }

      if (flag1 && j1 == i1 + 2) {
         for (int i2 = i1; i2 <= j1; i2++) {
            long i3 = par4 + aav.a[k1] * i2;
            long i4 = par6 + aav.b[k1] * i2;
            i3 += aav.a[l] * 4;
            i4 += aav.b[l] * 4;
            int i5 = par3World.getBlockId(i3, par5, i4);
            int i6 = par3World.getBlockMetadata(i3, par5, i4);
            if (i5 != Block.bI.bO || !BlockEndPortalFrame.e(i6)) {
               flag1 = false;
               break;
            }
         }

         for (int j2 = i1 - 1; j2 <= j1 + 1; j2 += 4) {
            for (int j3 = 1; j3 <= 3; j3++) {
               long j4 = par4 + aav.a[k1] * j2;
               long j5 = par6 + aav.b[k1] * j2;
               j4 += aav.a[l] * j3;
               j5 += aav.b[l] * j3;
               int j6 = par3World.getBlockId(j4, par5, j5);
               int k6 = par3World.getBlockMetadata(j4, par5, j5);
               if (j6 != Block.bI.bO || !BlockEndPortalFrame.e(k6)) {
                  flag1 = false;
                  break;
               }
            }
         }

         if (flag1) {
            for (int k2 = i1; k2 <= j1; k2++) {
               for (int k3 = 1; k3 <= 3; k3++) {
                  long k4 = par4 + aav.a[k1] * k2;
                  long k5 = par6 + aav.b[k1] * k2;
                  k4 += aav.a[l] * k3;
                  k5 += aav.b[l] * k3;
                  par3World.setBlockWithNotify(k4, par5, k5, Block.bH.bO);
               }
            }
         }
      }

      return true;
   }

   @Override
   public ItemStack a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      MovingObjectPosition movingobjectposition = this.a(par2World, par3EntityPlayer, false);
      if (movingobjectposition != null && movingobjectposition.a == aat.a) {
         int i = par2World.getBlockId(movingobjectposition.b, movingobjectposition.c, movingobjectposition.d);
         if (i == Block.bI.bO) {
            return par1ItemStack;
         }
      }

      if (!par2World.F) {
         ChunkPosition chunkposition = par2World.findClosestStructure("Stronghold", (long)par3EntityPlayer.o, (int)par3EntityPlayer.p, (long)par3EntityPlayer.q);
         if (chunkposition != null) {
            EntityEnderEye entityendereye = new EntityEnderEye(par2World, par3EntityPlayer.o, par3EntityPlayer.p + 1.62 - par3EntityPlayer.H, par3EntityPlayer.q);
            entityendereye.a(chunkposition.a, chunkposition.b, chunkposition.c);
            par2World.a(entityendereye);
            par2World.a(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (d.nextFloat() * 0.4F + 0.8F));
            par2World.playAuxSFXAtEntity(null, 1002, (long)par3EntityPlayer.o, (int)par3EntityPlayer.p, (long)par3EntityPlayer.q, 0);
            if (!par3EntityPlayer.aT.d) {
               par1ItemStack.a--;
            }
         }
      }

      return par1ItemStack;
   }
}
