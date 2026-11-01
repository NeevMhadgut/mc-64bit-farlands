public class EntityGiantZombie extends EntityMob {
   public EntityGiantZombie(World par1World) {
      super(par1World);
      this.bm = "/mob/zombie.png";
      this.TileEntityMobSpawner = 0.5F;
      this.c = 50;
      this.H *= 6.0F;
      this.a(this.I * 6.0F, this.J * 6.0F);
   }

   @Override
   public int d() {
      return 100;
   }

   public float a(int par1, int par2, int par3) {
      return this.k.getLightBrightness(par1, par2, par3) - 0.5F;
   }
}
