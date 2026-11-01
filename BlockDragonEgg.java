import java.util.Random;

public class BlockDragonEgg extends Block {
   public BlockDragonEgg(int par1, int par2) {
      super(par1, par2, acn.A);
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e());
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e());
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      this.fallIfPossible(par1World, par2, par3, par4);
   }

   private void fallIfPossible(World par1World, long par2, int par3, long par4) {
      long i = par2;
      int j = par3;
      long k = par4;
      if (BlockSand.canFallBelow(par1World, i, j - 1, k) && j >= 0) {
         byte byte0 = 32;
         if (!BlockSand.a && par1World.checkChunksExist(par2 - byte0, par3 - byte0, par4 - byte0, par2 + byte0, par3 + byte0, par4 + byte0)) {
            EntityFallingSand entityfallingsand = new EntityFallingSand(par1World, par2 + 0.5, par3 + 0.5, par4 + 0.5, this.bO);
            par1World.a(entityfallingsand);
         } else {
            par1World.setBlockWithNotify(par2, par3, par4, 0);

            while (BlockSand.canFallBelow(par1World, par2, par3 - 1, par4) && par3 > 0) {
               par3--;
            }

            if (par3 > 0) {
               par1World.setBlockWithNotify(par2, par3, par4, this.bO);
            }
         }
      }
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      this.teleportNearby(par1World, par2, par3, par4);
      return true;
   }

   @Override
   public void onBlockClicked(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      this.teleportNearby(par1World, par2, par3, par4);
   }

   private void teleportNearby(World par1World, long par2, int par3, long par4) {
      if (par1World.getBlockId(par2, par3, par4) == this.bO) {
         if (!par1World.F) {
            for (int i = 0; i < 1000; i++) {
               long j = par2 + par1World.r.nextInt(16) - par1World.r.nextInt(16);
               int k = par3 + par1World.r.nextInt(8) - par1World.r.nextInt(8);
               long l = par4 + par1World.r.nextInt(16) - par1World.r.nextInt(16);
               if (par1World.getBlockId(j, k, l) == 0) {
                  par1World.setBlockAndMetadataWithNotify(j, k, l, this.bO, par1World.getBlockMetadata(par2, par3, par4));
                  par1World.setBlockWithNotify(par2, par3, par4, 0);
                  char c = 128;

                  for (int i1 = 0; i1 < c; i1++) {
                     double d = par1World.r.nextDouble();
                     float f = (par1World.r.nextFloat() - 0.5F) * 0.2F;
                     float f1 = (par1World.r.nextFloat() - 0.5F) * 0.2F;
                     float f2 = (par1World.r.nextFloat() - 0.5F) * 0.2F;
                     double d1 = j + (par2 - j) * d + (par1World.r.nextDouble() - 0.5) * 1.0 + 0.5;
                     double d2 = k + (par3 - k) * d + par1World.r.nextDouble() * 1.0 - 0.5;
                     double d3 = l + (par4 - l) * d + (par1World.r.nextDouble() - 0.5) * 1.0 + 0.5;
                     par1World.a("portal", d1, d2, d3, f, f1, f2);
                  }

                  return;
               }
            }
         }
      }
   }

   @Override
   public int e() {
      return 3;
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return super.canPlaceBlockAt(par1World, par2, par3, par4);
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public int d() {
      return 27;
   }
}
