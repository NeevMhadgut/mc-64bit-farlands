public class MapGenMineshaft extends MapGenStructure {
   @Override
   protected boolean canSpawnStructureAtCoords(long par1, long par2) {
      return this.c.nextInt(100) == 0 && this.c.nextInt(80) < Math.max(Math.abs(par1), Math.abs(par2));
   }

   @Override
   protected StructureStart getStructureStart(long par1, long par2) {
      return new StructureMineshaftStart(this.d, this.c, par1, par2);
   }
}
