public interface IWorldAccess {
   void markBlockNeedsUpdate(long var1, int var3, long var4);

   void markBlockNeedsUpdate2(long var1, int var3, long var4);

   void markBlockRangeNeedsUpdate(long var1, int var3, long var4, long var6, int var8, long var9);

   void a(String var1, double var2, double var4, double var6, float var8, float var9);

   void a(String var1, double var2, double var4, double var6, double var8, double var10, double var12);

   void a(Entity var1);

   void b(Entity var1);

   void playRecord(String var1, long var2, int var4, long var5);

   void doNothingWithTileEntity(long var1, int var3, long var4, TileEntity var6);

   void playAuxSFX(EntityPlayer var1, int var2, long var3, int var5, long var6, int var8);

   void stupidFuckingMethodSolelyForSprintingBecauseFuckMeIGuess(Entity var1, int var2, long var3, int var5, long var6, int var8, int var9);
}
