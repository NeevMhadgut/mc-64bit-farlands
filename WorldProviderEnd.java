public class WorldProviderEnd extends WorldProvider {
   @Override
   public void a() {
      this.c = new WorldChunkManagerHell(BiomeGenBase.k, 0.5F, 0.0F);
      this.g = 1;
      this.e = true;
   }

   @Override
   public IChunkProvider b() {
      return new ChunkProviderEnd(this.a, this.a.v());
   }

   @Override
   public float a(long par1, float par3) {
      return 0.0F;
   }

   @Override
   public float[] a(float par1, float par2) {
      return null;
   }

   @Override
   public bo b(float par1, float par2) {
      int i = 8421536;
      float f = MathHelper.b(par1 * (float) Math.PI * 2.0F) * 2.0F + 0.5F;
      if (f < 0.0F) {
         f = 0.0F;
      }

      if (f > 1.0F) {
         f = 1.0F;
      }

      float f1 = (i >> 16 & 0xFF) / 255.0F;
      float f2 = (i >> 8 & 0xFF) / 255.0F;
      float f3 = (i & 0xFF) / 255.0F;
      f1 *= f * 0.0F + 0.15F;
      f2 *= f * 0.0F + 0.15F;
      f3 *= f * 0.0F + 0.15F;
      return bo.b(f1, f2, f3);
   }

   @Override
   public boolean c() {
      return false;
   }

   @Override
   public boolean d() {
      return false;
   }

   @Override
   public boolean e() {
      return false;
   }

   @Override
   public float f() {
      return 8.0F;
   }

   @Override
   public boolean canCoordinateBeSpawn(long par1, long par2) {
      int i = this.a.getFirstUncoveredBlock(par1, par2);
      return i == 0 ? false : Block.m[i].cd.c();
   }

   @Override
   public ChunkCoordinates g() {
      return new ChunkCoordinates(100L, 50, 0L);
   }

   @Override
   public int h() {
      return 50;
   }

   @Override
   public boolean func_48218_b(long par1, long par2) {
      return true;
   }
}
