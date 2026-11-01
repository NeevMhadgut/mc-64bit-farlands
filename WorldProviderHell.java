public class WorldProviderHell extends WorldProvider {
   @Override
   public void a() {
      this.c = new WorldChunkManagerHell(BiomeGenBase.j, 1.0F, 0.0F);
      this.d = true;
      this.e = true;
      this.g = -1;
   }

   @Override
   public bo b(float par1, float par2) {
      return bo.b(0.2F, 0.03F, 0.03F);
   }

   @Override
   protected void i() {
      float f = 0.1F;

      for (int i = 0; i <= 15; i++) {
         float f1 = 1.0F - i / 15.0F;
         this.f[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
      }
   }

   @Override
   public IChunkProvider b() {
      return new ChunkProviderHell(this.a, this.a.v());
   }

   @Override
   public boolean e() {
      return false;
   }

   @Override
   public boolean canCoordinateBeSpawn(long par1, long par2) {
      return false;
   }

   @Override
   public float a(long par1, float par3) {
      return 0.5F;
   }

   @Override
   public boolean d() {
      return false;
   }

   @Override
   public boolean func_48218_b(long par1, long par2) {
      return true;
   }
}
