public interface IBlockAccess {
   int getBlockId(long var1, int var3, long var4);

   TileEntity getBlockTileEntity(long var1, int var3, long var4);

   int getLightBrightnessForSkyBlocks(long var1, int var3, long var4, int var6);

   float getBrightness(long var1, int var3, long var4, int var6);

   float getLightBrightness(long var1, int var3, long var4);

   int getBlockMetadata(long var1, int var3, long var4);

   acn getBlockMaterial(long var1, int var3, long var4);

   boolean isBlockOpaqueCube(long var1, int var3, long var4);

   boolean isBlockNormalCube(long var1, int var3, long var4);

   boolean isAirBlock(long var1, int var3, long var4);

   BiomeGenBase getBiomeGenForCoords(long var1, long var3);

   int b();

   boolean a();
}
